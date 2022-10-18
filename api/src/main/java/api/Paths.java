package api;

public interface Paths {

    String itemId = "itemId";
    String userId = "userId";
    String imageId = "imageId";


//    String MAIN = "/sandelis";

    String CART = "/cart";


    String ITEMS = "/items";
    String ITEM = "/{"+itemId+"}";
    String ADD_ITEM = "/additem";

    String ISSUE_ITEM = "/issue";
    String ISSUED = ITEM+"/issued";
    String SEARCH = "/search";

    String USERS = "/users";
    String USER = "/{"+userId+"}";
    String LOGIN = "/login";


    String IMAGE_FILES ="/files";
    String IMAGE_FILE = "/{"+imageId+"}";
}
