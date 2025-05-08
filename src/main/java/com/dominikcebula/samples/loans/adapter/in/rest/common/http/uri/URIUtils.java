package com.dominikcebula.samples.loans.adapter.in.rest.common.http.uri;

import java.net.URI;

public class URIUtils {
    private URIUtils() {
    }

    public static URI pathTo(String base, int path) {
        return pathTo(base, String.valueOf(path));
    }

    public static URI pathTo(String base, String path) {
        if (!base.endsWith("/"))
            base += "/";

        return URI.create(base).resolve(path);
    }
}
