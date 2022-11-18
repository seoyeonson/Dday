      var swiper = new Swiper(".mySwiper", {
        spaceBetween: 30,    // 슬라이드 사이 여백

        slidesPerView : 'auto', // 한 슬라이드에 보여줄 갯수
        centeredSlides: true,    //센터모드
        autoplay: {     //자동슬라이드 (false-비활성화)
          delay: 2500, // 시간 설정
          disableOnInteraction: false, // false-스와이프 후 자동 재생
        },

        loop : false,   // 슬라이드 반복 여부

        loopAdditionalSlides : 1,

 // 슬라이드 반복 시 마지막 슬라이드에서 다음 슬라이드가 보여지지 않는 현상 수정
        pagination: { // 호출(pager) 여부
          el: ".swiper-pagination", //버튼을 담을 태그 설정
          clickable: true, // 버튼 클릭 여부
        },
        navigation: {   // 버튼
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
      });

      const swiper = new Swiper('.swiper', {
        // Optional parameters
        direction: 'vertical',
        loop: true,
      
        // If we need pagination
        pagination: {
          el: '.swiper-pagination',
        },
      
        // Navigation arrows
        navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev',
        },
      
        // And if we need scrollbar
        scrollbar: {
          el: '.swiper-scrollbar',
        },
      });