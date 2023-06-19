package com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.rest.resource;

import lombok.Data;

@Data
public class Thumbnail{
    public String path;
    public String extension;

    public String getURL(){
        return path.concat(".").concat(extension);
    }
}
