$(document).ready(function() {
    $( "#startingPoint" ).autocomplete({
      source: function( request, response ) {
        $.ajax( {
//          url: "http://192.168.0.105:8087/api_v1/postcode?postcode=",
          url: "http://backend:8087/api_v1/postcode?postcode=",
          postcode: request.term,
          success: function( postcode ) {
            response( postcode );
          }
        } );
      },
      minLength: 2,
      select: function( event, ui ) {
        console.log( "Selected: " + ui.item.value  );
      }
    } );
     $( "#destinationPoint" ).autocomplete({
      source: function( request, response ) {
        $.ajax( {
//          url: "http://192.168.0.105:8087/api_v1/postcode?postcode=",
          url: "http://backend:8087/api_v1/postcode?postcode=",
          postcode: request.term,
          success: function( postcode ) {
            response( postcode );
          }
        } );
      },
      minLength: 2,
      select: function( event, ui ) {
        console.log( "Selected: " + ui.item.value  );
      }
    } );

    $("#searchButton").click(function(){
	search();
    });
    function search(){
		console.log("search");
		var start = $("#startingPoint").val();
		var dest = $("#destinationPoint").val();
		$.ajax({
//			url: "http://localhost:8087/api_v1/distance?startPostCode="+start+"&destinationPostCode="+dest
                        url: "http://backend:8087/api_v1/distance?startPostCode="+start+"&destinationPostCode="+dest
		}).then(function(data) {
			console.log(data);
			$('#distanceLabel').text("Distance beetween ").append(start) . append (" and ") .append(dest) . append( " is " ) .append  (data.distance).append(" " ).append(data.unit);
		});
	}
});
