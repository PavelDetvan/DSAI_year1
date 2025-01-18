package designpat.websearch;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Perform "web search" (from a file), notify the interested observers of each
 * query.
 * @author Pavel Detvan & Martin Popov
 */
public class WebSearchModel {
    private final File sourceFile;
    //private final List<QueryObserver> observers = new ArrayList<>();
    private final Map<QueryObserver, QueryFilter> observers = new HashMap<>(); //storing queryObserver and queryFilter together

    public interface QueryObserver {
        void onQuery(String query);
    }

    public interface QueryFilter{
        boolean notify(String query);
    }

    public WebSearchModel(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void pretendToSearch() {
        // Source:
        // https://stackoverflow.com/questions/5868369/how-can-i-read-a-large-text-file-line-by-line-using-java
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                notifyAllObservers(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addQueryObserver(QueryObserver queryObserver, QueryFilter filter) {
        observers.put(queryObserver, filter);
    }

    private void notifyAllObservers(String line) {
        for (Map.Entry<QueryObserver, QueryFilter> pair : observers.entrySet()) {
            QueryFilter filter = pair.getValue();
            QueryObserver observer = pair.getKey();
            if(filter.notify(line)){
                observer.onQuery(line);
            }
        }
    }
}
