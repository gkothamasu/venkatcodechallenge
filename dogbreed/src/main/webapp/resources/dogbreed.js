/**
 * 
 */

$(document)
	.ready(
		function() {
			// Select group by breed
			$("#breedgroup").empty();
			var thisurl = 'http://localhost:8080/dogbreed/dogbreed/breeds';
			$
				.ajax({
					type : "GET",
					url : thisurl,
					dataType : "json",
					success : function(result) {
						var itemhtml = "<option value=''>&nbsp;</option>";
						for (var i = 0; i < result.length; i++) {
							var dog = result[i];
							itemhtml += "<option value='" + dog
								+ "'>" + dog + "</option>";
						}
						$("#breedgroup").append(itemhtml);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log('error: ' + textStatus + ': '
							+ errorThrown);
					}
				});

			// List All Dogs
			$('a.alldogs')
				.click(
					function() {
						$("#dogbreeddisplay").empty();
						var url = 'http://localhost:8080/dogbreed/dogbreed/dogs?breed';
						$
							.ajax({
								type : "GET",
								url : url,
								dataType : "json",
								success : function(result) {
									var finalhtml = dogHtml(result);
									$("#dogbreeddisplay").append(finalhtml);
									/*document
										.getElementById("dogbreeddisplay").innerHTML = finalhtml;*/
								// alert(document.getElementById("dogbreeddisplaydiv"));
								},
								error : function(jqXHR,
									textStatus,
									errorThrown) {
									console.log('error: '
										+ textStatus
										+ ': '
										+ errorThrown);
								}
							});
					});

			// Select group by breed
			$('.breedgroup')
				.change(
					function() {
						$("#dogbreeddisplay").empty();
						var selectedbreed = $(this).val();
						var url = 'http://localhost:8080/dogbreed/dogbreed/dogs?breed='
							+ selectedbreed;
						$
							.ajax({
								type : "GET",
								url : url,
								dataType : "json",
								success : function(result) {
									var finalhtml = dogHtml(result);
									$("#dogbreeddisplay").append(finalhtml);
								/*document
										.getElementById("dogbreeddisplay").innerHTML = finalhtml;*/
								},
								error : function(jqXHR,
									textStatus,
									errorThrown) {
									console.log('error: '
										+ textStatus
										+ ': '
										+ errorThrown);
								}
							});
					});

			// Favorite Count
			$( '#wrapper' ).on( 'click', 'a.upvote', function (event) { 
				var id = event.target.id;
				var urlstring =id+"/1"; 
				/*if($(event.target).hasclass('.upvote')){
					 urlstring =id+"/1"; 
				}else {
					 urlstring =id+"/0";
				}*/
						var url = 'http://localhost:8080/dogbreed/dogbreed/updateFav/'+urlstring;
						$.ajax({
							type : "GET",
							url : url,
							dataType : "json",
							success : function(result) {},
							error : function(jqXHR, textStatus,
								errorThrown) {
								console.log('error: '
									+ textStatus + ': '
									+ errorThrown);
							}
						});
					});
			
			$( '#wrapper' ).on( 'click', 'a.downvote', function (event) { 
				var id = event.target.id;
				var urlstring =id+"/0"; 
				
				var url = 'http://localhost:8080/dogbreed/dogbreed/updateFav/'+urlstring;
				$.ajax({
					type : "GET",
					url : url,
					dataType : "json",
					success : function(result) {},
					error : function(jqXHR, textStatus,
						errorThrown) {
						console.log('error: '
							+ textStatus + ': '
							+ errorThrown);
					}
				});
			});

			var dogHtml = function(result) {
				var headingDiv = "";
				var htmlstrbgn = "<div class='row center'  'style' = margin-left: 75px; >";
				var htmlendstr = "</div>";
				var prodlisthtm_1 = "";
				var prodlisthtm_2 = "</ul></div>";
				var finalHtml = "";

				$
					.map(
						result,
						function(value, index) {
							headingDiv += htmlstrbgn + index
								+ htmlendstr;
							finalHtml += headingDiv;

							prodlisthtm_1 = htmlstrbgn
								+ "<ul class='products'>";
							finalHtml += prodlisthtm_1;
							var itemhtml = "";
							for (var i = 0; i < value.length; i++) {
								var dog = value[i];
								itemhtml += "<li ><a href='#'><img id ='dogdetail' src='.."
									+ dog.pictureUrl
									+ "'/></a><h4>"
									+ dog.name
									+ "</h4><p>"
									+ dog.favCount
									+ "</p>"
									+ "<p>  " +
											"<a id='"+dog.id+"' class='favCount upvote' href='#' ><img id ='" + dog.id + "'  class='upvote' alt ='upvote' src='../images/up.jpg'  style='width:15px' /></a> </p>" +
									"<p> <a id='" + dog.id + "' class='favCount downvote' href='#'><img id ='" + dog.id + "' class='downvote' alt ='downvote' src='../images/down.jpg' style='width:15px' /></a> </p>" +
									"</li>";
							}
							finalHtml += itemhtml
								+ prodlisthtm_2;
								// alert(finalHtml);

						});

				finalHtml += htmlendstr;

				return finalHtml;
			}

		});