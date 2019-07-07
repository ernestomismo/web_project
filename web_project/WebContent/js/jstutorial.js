/**
 * 
 */

var myHeading = document.querySelector('h1');
myHeading.textContent = 'Hello world! TU PUTA MADRE!!!';

var myImage = document.querySelector('img');

myImage.onclick = function() {
    var mySrc = myImage.getAttribute('src');
    if(mySrc === 'images/firefox-icon.png') {
      myImage.setAttribute ('src','images/1346759876629.gif');
    } else {
      myImage.setAttribute ('src','images/firefox-icon.png');
    }
}