package com.example.administrator.retroitfetchdata.network.survey;

import java.util.List;

public class SurveyResponse {
    public boolean success;
    public int page;
    public int limit;
    public int totalPages;
    public int nextPage;
    public int totalRecordsFound;
    public List<Survey> survey;
}
