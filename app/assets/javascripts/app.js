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
		  			table.append("<tr><th>Year</th><th>Balance(Wells)</th><th>Balance(SOFI)</th><</tr>");
		  			 $.each(data, function(key, val) {
		  				 wellsTotal = wellsTotal + val.wellsBalance;
		  				 sofiTotal = sofiTotal + val.sofiBalance;
		  				 wells = val.wellsBalance;
		  				 wells = wells.toLocaleString('en');
		  				 sofi = val.sofiBalance;
		  				 sofi = sofi.toLocaleString('en');
		  			table.append("<tr><td>" + val.year+ "</td><td> $" + wells + "</td> <td>$" + sofi + "</td></tr><br />");
		  			 });
		  			 diff = sofiTotal - wellsTotal;

		  			 diff = diff.toFixed(2);

		  			 table.append("<tr><td>Ended Up with this Amount: </td><td>$" + diff + " </td></tr>");
		  			$("#results").append(table);
	       });
});

