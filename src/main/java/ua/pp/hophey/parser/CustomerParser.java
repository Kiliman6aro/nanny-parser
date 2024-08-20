package ua.pp.hophey.parser;

import ua.pp.hophey.model.entity.NannyCustomer;

public interface CustomerParser {
    NannyCustomer parse(String url);
}
