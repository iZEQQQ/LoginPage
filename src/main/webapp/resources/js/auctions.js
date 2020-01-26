$(document).ready(function() {
    $.get( "/login/api/branches", function( data ) {
        renderBranches(data);
    });
});

function renderBranches(branches){
    $("#branches").removeClass("hidden");
    $("#categories").addClass("hidden");
    $("#auctions").addClass("hidden");
    let branchesBody = $("#branchesBody");
    branchesBody.empty();
    for(let branch of branches){
        branchesBody.append($("<tr>").append($("<td>").text(branch.name)).append($("<td>").append($("<button>").text("Show").click(function () {
            $.get( "/login/api/branches/"+branch.name+"/categories", function( data ) {
                renderCategories(branch.name, data);
            });
        }))));
    }
}

function renderCategories(branchName, categories){
    $("#categories").removeClass("hidden");
    $("#auctions").addClass("hidden");
    let categoriesBody = $("#categoriesBody");
    categoriesBody.empty();
    for(let category of categories){
        categoriesBody.append($("<tr>").append($("<td>").text(category.name)).append($("<td>").append($("<button>").text("Show").click(function () {
            $.get( "/login/api/branches/"+branchName+"/categories/"+category.name+"/auctions", function( data ) {
                renderAuctions(data);
            }); 
        }))));
    }
}

function renderAuctions( auctions){
    $("#auctions").removeClass("hidden");
    let auctionsBody = $("#auctionsBody");
    auctionsBody.empty();
    for(let auction of auctions){
        auctionsBody.append($("<tr>").append($("<td>").text(auction.id)).append($("<td>").append($("<button>").text("Buy").click(function () {

        }))));
    }
}

//TODO dodac popupy w koszyku powinien byc w slide