let pairCoordinateVertex=[];
let edges=[];
var name;

function getMouseCoordinates(event) {
    var x, y;
    x = event.clientX + document.body.scrollLeft + document.documentElement.scrollLeft;
    y = event.clientY + document.body.scrollTop + document.documentElement.scrollTop + 1;
    console.log(x);
    console.log(y);
    pairCoordinateVertex.push({
        xCoordinate:x,
        yCoordinate:y
    });
    console.log(pairCoordinateVertex.length);
    return [x, y];
}
function saveGraph(){

}
function saveName(){
    name=document.querySelector('input').value;
    edges.push({
        first:"1",
        second:"2"
    })
    sendSaveRequest();
    close();
}
function sendSaveRequest(){
    let graph = {
        name: name,
        vertexesList: pairCoordinateVertex,
        edgesList: edges,
    };

    let json = JSON.stringify(graph);
    console.log(json);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/about");
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);
}
function save() {
    var dialog = document.getElementById("saveDialog");
    dialog.show();
}
function close() {
    var dialog = document.getElementById("saveDialog");
    dialog.close();
}
