package leetcode.range1400_1500;

public class DesignBrowserHistory {

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }

    static class BrowserHistory {

        DNode current;

        public BrowserHistory(String homepage) {
            this.current = new DNode(homepage);
        }

        public void visit(String url) {
            DNode next = new DNode(url);
            this.current.next = next;
            next.prev = current;
            this.current = next;
        }

        public String back(int steps) {
            while (steps-- > 0 && current.prev != null) {
                current = current.prev;
            }
            return current.url;
        }

        public String forward(int steps) {
            while (steps-- > 0 && current.next != null) {
                current = current.next;
            }
            return current.url;
        }

        class DNode {
            String url;
            DNode next;
            DNode prev;

            DNode(String url) {
                this.url = url;
            }
        }
    }
}
