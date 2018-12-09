package com.example.administrator.retroitfetchdata.history.HistoryResponse;

import java.util.List;

public class HistoryResponse {
  public boolean success;
  public int page;
  public int limit;
  public int totalPages;
  public int nextPage;
  public int totalRecordsFound;
  public List< SurveyHistory> surveyHistory ;

}
