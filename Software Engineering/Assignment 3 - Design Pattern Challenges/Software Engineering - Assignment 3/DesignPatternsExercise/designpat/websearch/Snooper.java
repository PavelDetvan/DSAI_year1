package designpat.websearch;

import designpat.websearch.WebSearchModel.QueryFilter;
import designpat.websearch.WebSearchModel.QueryObserver;

/**
 * Watches the search queries
 * @author Pavel Detvan & Martin Popov
 */
public class Snooper {
    private final WebSearchModel model;

    public Snooper(WebSearchModel model) {
        this.model = model;

        //queryobserver + queryfilter for "friends"
        QueryObserver queryObserverFriend = new QueryObserver() {

            @Override
            public void onQuery(String query) {
                System.out.println("Oh yes! " + query);
            }
        };

        QueryFilter queryFilterFriend = new QueryFilter() {

            @Override
            public boolean notify(String query) {
                return query.toLowerCase().contains("friend");
            }
            
        };

        model.addQueryObserver(queryObserverFriend, queryFilterFriend);

        //queryobserver + queryfilter for long queries
        QueryObserver queryObserverLong = new QueryObserver() {

            @Override
            public void onQuery(String query) {
                System.out.println("So long....! " + query);
            }
            
        };

        QueryFilter queryFilterLong = new QueryFilter() {

            @Override
            public boolean notify(String query) {
                return query.length() > 60;
            }
            
        };

        model.addQueryObserver(queryObserverLong, queryFilterLong);
        
    }
}
