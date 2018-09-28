package infrastructure.filters;

import play.filters.cors.CORSFilter;
import play.http.HttpFilters;
import play.mvc.EssentialFilter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filters implements HttpFilters {

    @Inject
    CORSFilter corsFilter;

    @Override
    public List<EssentialFilter> getFilters() {
        return Arrays.asList(new EssentialFilter[]{corsFilter.asJava()});
    }
}
