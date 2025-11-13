import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  private apiUrl = '/api/flights';

  constructor(private http: HttpClient) { }

  getFlights(source: string, destination: string, travelDate: string): Observable<any> {
    return this.http.get(this.apiUrl, {
      params: {
        source,
        destination,
        travelDate
      }
    });
  }
}
