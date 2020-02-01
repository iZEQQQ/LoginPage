function addToBasket(auctionId) {
    $.ajax({
        type: "POST",
        url: "/login/api/bucket/elements",
        data: JSON.stringify({'auctionid': auctionId}),
        contentType: "application/json"
    });
}
// TODO pododawac wiecej elementow
function showBasket() {
    $.ajax({
        type: "GET",
        url: "/login/api/bucket/elements",

    }).done(function (data) {
        console.log(data);
        let basketBody = $('#basketBody');
        let basket = $('#basket');
        basketBody.empty();
        for (let element of data) {
           basketBody.append($('<tr>').append('<td>').text(element.auction.title));
        }
        basket.show();
    });
}