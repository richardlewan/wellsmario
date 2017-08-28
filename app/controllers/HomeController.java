package controllers;

import static play.libs.Json.toJson;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.inject.Inject;
import com.sofi.wealth.retirement.AnnualResult;
import com.sofi.wealth.retirement.Calculator;
import com.sofi.wealth.retirement.Row;

import models.InputForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {


    @Inject
    private FormFactory formFactory;
    Calculator sofi;
    Calculator wells;
    InputForm input;

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result intro() {
        return ok(views.html.intro.render());
    }

    public Result calc() {
         input = formFactory.form(InputForm.class).bindFromRequest().get();
         System.out.println("Years from the input is: " + input.getYears());
         sofi = new Calculator(input.getYears(), 0.0d, 0.0037d, input.getSavings(), input.getMonthlyAmount() );
         wells = new Calculator(input.getYears(), 0.01d, 0.0125d, input.getSavings(), input.getMonthlyAmount() );
         return redirect(routes.HomeController.index());
    }

    public Result getResults() {
        Iterator<AnnualResult> wellsResults = wells.getResults().iterator();
        Iterator<AnnualResult> sofiResults = sofi.getResults().iterator();

        List<Row> tableCollection = new LinkedList<>();
        while (wellsResults.hasNext()) {
            Row row = new Row();
            AnnualResult wellsResult = wellsResults.next();
            row.setYear(wellsResult.getYear());
            row.setWellsBalance(wellsResult.getEndingBalance());
            row.setSofiBalance(sofiResults.next().getEndingBalance());
            tableCollection.add(row);
        }
      return ok(toJson(tableCollection));
    }

    public Result login() {
        return ok(views.html.login.render());
    }

}
