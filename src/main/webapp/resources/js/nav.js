(function(){
    let anchors = document.querySelectorAll(".form");
    let location = window.location;
    for(let i=0;i<anchors.length;i++){
        if(anchors[i].href === location.href){
            anchors[i].classList.add("active");
        }
    }
})