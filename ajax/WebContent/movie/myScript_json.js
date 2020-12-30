/**
 * 	영화진흥 위원회 API - JSON로 받는 경우
 */

$(function(){
	init();
	
	$("#btn1").click(function(){
		let url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=";
		url += $("#txtYear").val()+$("#selMon").val()+$("#selDay").val();
		let str = "";

			$.getJSON({
				url : url,
				success:function(data){

					$(data.boxOfficeResult.dailyBoxOfficeList).each(function(idx, item){
					
					// 순위
					str += item.rank+" 위";

					// 증감
					var rankInten = parseInt(item.rankInten);
					if(rankInten > 0){
						str = str + "(△";
					}else if(rankInten < 0){
						str = str + "(▽";
					}else{
						str = str +"(";
					}
					str += rankInten +")";

					// 영화 코드
					var movieCd = item.movieCd;
					
					// 영화명
					var movieNm = item.movieNm+"<br>";
					str += "<a href='#' onclick='javascript:info("+movieCd+")'>"+movieNm+"</a>";

					$("#msg").html(str);
				})
			},
			error:function(xhr, txtStatus, error){
				alert("코드 확인 필요");
			}
		})
	})
})

function info(movieCd){
	//영화 상세정보 요청 - 영화제목, 영어제목, 상영시간, 감독, 출연배우
	var url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd="+movieCd;
	

	
	$.get({
		url : url,
		success:function(data){
			console.log(data);
			
			let movieInfo = data.movieInfoResult.movieInfo;
			
			
			let str = "<ul>";
			
			// 영화명 - 국문
			var movieNm = movieInfo.movieNm;
			// 영화명 - 영문
			var movieNmEn = movieInfo.movieNmEn;
			// 상영시간
			var showTm = movieInfo.showTm;
			// 감독명
			var peopleNm = movieInfo.directors[0].peopleNm;
			// 배우들
			/* var actors = "";
			$(data).find('actor').each(function(){
				actors += $(this).find('peopleNm').text();
			}); */
			
			var actors = "";
			var actors_length = movieInfo.actors.lengh;
			
			$(movieInfo.actors).each(function(idx, item){ // for(i in 배열)
				if(idx == actors_length-1){
				actors += item.peopleNm;
				
				}else{
				actors += item.peopleNm+",";					
				}
			});
			
			// 상세정보 출력
				str += "<li>영화제목 : "+movieNm+"</li><br>";
				str += "<li>영어제목 : "+movieNmEn+"</li><br>";
				str += "<li>상영시간 : "+showTm+"</li><br>";
				str += "<li>감독 : "+peopleNm+"</li><br>";
				str += "<li>출연배우 : "+actors+"</li></ul>";
			
			// 출력위치
				$(".box3").html(str);

		},
		error:function(xhr, txtStatus, error){
			alert("코드 확인 필요");
		}
	})
}

function init(){
	// 어제 날자 세팅
	var newDate = new Date();
	var year = newDate.getFullYear();
	var month = newDate.getMonth()+1;
	var day = newDate.getDate()-1;

	$("#txtYear").val(year);
	
	if(month<10){
		month = "0"+month;
	}
	if(day<10){
		day = "0"+day;
	}
	$("#selMon").val(month);
	$("#selDay").val(day);
}