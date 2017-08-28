$( document ).ready(function() {
	$.getJSON('/results',
	          function(data) {
	              // data is a JSON
		  			var table = $('table');
		  			var well = 0.0;
		  			var sofi = 0.0;
		  			var wellsTotal = 0.0;
		  			var sofiTotal = 0.0;
		  			var diff = 0.0;
		  			table.append("<tr><th>Year</th><th>Balance(Wells)</th><th>Balance(SoFi)</th><</tr>");
		  			 $.each(data, function(key, val) {
		  				 wellsTotal = val.wellsBalance;
		  				 sofiTotal = val.sofiBalance;
		  				 wells = val.wellsBalance;
		  				 wells = wells.toLocaleString('en');
		  				 sofi = val.sofiBalance;
		  				 sofi = sofi.toLocaleString('en');
		  			table.append("<tr><td>" + val.year+ "</td><td> $" + wells + "</td> <td>$" + sofi + "</td></tr><br />");
		  			 });
		  			 diff = sofiTotal - wellsTotal;
		  			 diff = diff.toLocaleString('en');

		  			 $("#finalResult").append("<b>You lost this much with Wells Fargo: &nbsp;&nbsp; $" + diff + "");
		  			 $("#finalResult").css("background-color", "#fbff8e");
		  			$("#results").append(table);
	       });
});

