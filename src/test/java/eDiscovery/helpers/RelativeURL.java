package eDiscovery.helpers;

public class RelativeURL {

    public static final String URL_SEARCH_QUERY_LIST                        = "/search-query/list";
    public static final String URL_METADATA_FILTERS_LIST                    = "/metadata-filters/list";
    public static final String URL_SEARCH_PLACES_LIST                       = "/search-places/list";
    public static final String URL_SEARCH_PLACE_GROUP_LIST                  = "/search-places/groups/list";
    public static final String URL_DEAL_LIST                                = "/deal/list";
    public static final String URL_CLASSIFIER_MARKER_LIST                   = "/classifier/marker/list";
    public static final String URL_CLASSIFIER_ENCRYPTION_PERMISSION_LIST    = "/classifier/encryption-permission/list";
    public static final String URL_CLASSIFIER_SEARCH_QUERY_LIST             = "/classifier/search-query/list";
    public static final String URL_CLASSIFIER_RULES_LIST                    = "/classifier/rules/list";
    public static final String URL_CLASSIFIER_PROFILES_LIST                 = "/classifier/profiles/list";
    public static final String URL_CLASSIFIER_MARKER_RESULT_LIST            = "/classifier/results/list";
    public static final String URL_AGENTS_LIST                              = "/agents/list";
    public static final String URL_SYSTEM_EVENTS_LIST                       = "/administration/system-events/list";
    public static final String URL_SYSTEM_SETTINGS                          = "/settings/system-settings";
    public static final String URL_FILE_TYPES                               = "/settings/file-types/list";
    public static final String URL_FILE_EXTENSIONS                          = "/settings/file-extensions/list";

    public static String getFullUrl(String location){
        return String.format("%s%s", System.getProperty("BASE_URL"), location);
    }
}
