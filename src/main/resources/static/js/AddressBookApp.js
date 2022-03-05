let count = 0;

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
            userName: input
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
                updateBook(addressBook.userName, addressBook.addressBookId, addressBook.numBuddies);
                document.getElementById("addressBookSelect").innerHTML +=
                    "<option value=" + addressBook.addressBookId + ">" + addressBook.addressBookId + "</option>";
            });
        }
    });
}

function updateBook(userName, value, numBuddies) {
    $('#books').append(
        "<tr>" +
        "<td>" + userName + "</td>" +
        "<td>" + value + "</td>" +
        "</tr>"
    );
    getBuddies(value, numBuddies);
}


function getBuddies(value, numBuddies) {
    $.ajax({
        type: "GET",
        url: '/AddressBook/' + value + '/buddies',
        dataType: "json",
        success: function (data) {
            updateBuddies(data, numBuddies);
        }
    });
}


function updateBuddies(data, numBuddies) {
    for (let i = 0; i < numBuddies; i++) {
        $('#buddies').append(
            "<tr>" +
            "<td>" + data._embedded.BuddyInfo[i].name + "</td>" +
            "<td>" + data._embedded.BuddyInfo[i].phone + "</td>" +
            "<td>" + data._embedded.BuddyInfo[i].addressBookId + "</td>" +
            "</tr>"
        );
    }
}