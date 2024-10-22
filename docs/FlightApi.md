# FlightApi

All URIs are relative to *https://localhost:8050*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getFlights**](FlightApi.md#getFlights) | **GET** /flights | Get all flight options for source to destination

<a name="getFlights"></a>
# **getFlights**
> Flight getFlights(body)

Get all flight options for source to destination

Fetch flight details from airlines

### Example
```java
// Import classes:
//import com.fs.scanner.handler.ApiException;
//import com.fs.scanner.handler.FlightApi;


FlightApi apiInstance = new FlightApi();
Flight body = new Flight(); // Flight | Flight details required for querying airlines
try {
    Flight result = apiInstance.getFlights(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlightApi#getFlights");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Flight**](Flight.md)| Flight details required for querying airlines |

### Return type

[**Flight**](Flight.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

