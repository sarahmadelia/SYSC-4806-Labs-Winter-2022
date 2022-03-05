/**
 *
 * Updated for Lab 6
 * Lab 5 functionality partially incomplete
 * (moving on to do Lab 6)
 *
 * @author Sarah Abdallah
 * @version 2022-03-04
 */
function newAddressBook() {
    let input = document.getElementById('addressBookName').value;
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: '/AddressBook/new',
        dataType: "json",
        data: JSON.stringify({
            name: input
        })
    });
    setTimeout(function () {
        count++;
        updateData();
    }, 1000);
}

function newBuddy() {
    let ABID_input = document.getElementById('addressBookSelect').value;
    let name_input = document.getElementById('buddyName').value;
    let phone_input = document.getElementById('buddyPhone').value;
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: '/AddressBook/addBuddy',
        dataType: "json",
        data: JSON.stringify({
            addressBookId: ABID_input,
            name: name_input,
            phone: phone_input
        })
    });
    setTimeout(function () {
        count++;
        updateData();
    }, 1000);

}

function updateData() {
    $('#books').empty();
    $('#buddies').empty();
    $('#addressBookSelect').empty();
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: '/AddressBook',
        dataType: "json",
        success: function (data) {
            data._embedded.AddressBook.forEach(function (addressBook) {
                updateBook(addressBook.name, addressBook.addressBookID);
                document.getElementById("addressBookSelect").innerHTML +=
                    "<option value=" + addressBook.addressBookID + ">" + addressBook.addressBookID + "</option>";
            });
        }
    });
}

function updateBook(name, value) {
    $('#books').append(
        "<tr>" +
        "<td>" + name + "</td>" +
        "<td>" + value + "</td>" +
        "</tr>"
    );
    //getMyBuddies(value, numBuddies);
}

