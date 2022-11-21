const $categorygate = $('.css1-line');
const $category = $('.category');
const $subcategory = $('.css-13ct7qm');
const $subsubcategory = $('.css-you2kh');
const $menubar = $('.menubar');
const $service = $('.service_centor');

var service = $service[0];
var menubar = $menubar[0];
var category = $category[0];
var subcategory = $subcategory[0];
var categorygate = $categorygate[0];
var gray = $('.gray')[0];

categorygate.addEventListener('mouseover',function(){
    category.style.display='block';
});

category.addEventListener('mouseout',function(){
    category.style.display='none';
});

gray.addEventListener('mouseover',function(){
    gray.style.color='black';
});

gray.addEventListener('mouseout',function(){
    gray.style.color='#b5b5b5';
});


service.addEventListener('mouseover',function(){
    menubar.style.display='block';
});

menubar.addEventListener('mouseout',function(){
    menubar.style.display='none';
});

service.addEventListener('mouseout',function(){
    menubar.style.display='none';
});

let header = document.querySelector(".header");
let headerHeight = header.offsetHeight;

window.onscroll = function () {
  let windowTop = window.scrollY;
  	// 스크롤 세로값이 헤더높이보다 크거나 같으면 
	// 헤더에 클래스 'drop'을 추가한다
  if (windowTop >= headerHeight) {
    header.classList.add("drop");
  } 
  // 아니면 클래스 'drop'을 제거
  else {
    header.classList.remove("drop");
  }
};