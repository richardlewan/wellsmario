$.getJSON('/results',
          function(data) {
              // data is a JSON
	  			var table = $('table');
	  			table.append("<tr><th>Year</th><th>Balance(Wells)</th><th>Balance(SOFI)</th></tr>");
	  			 $.each(data, function(key, val) {
	  			table.append("<tr><td>" + val.year+ "</td><td>" + val.wellsBalance+ "</td> <td>" + val.sofiBalance+ "</td></tr><br />");
	  			 });
	  			$("#table").append(table);
       });