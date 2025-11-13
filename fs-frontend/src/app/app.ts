import { Component } from '@angular/core';
import { Header } from './header/header';
import { FlightSearch } from './flight-search/flight-search';
import { FlightResults } from './flight-results/flight-results';
import { FlightService } from './services/flight';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [Header, FlightSearch, FlightResults],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  flights: any[] = [];

  constructor(private flightService: FlightService) {}

  onSearch(searchCriteria: any) {
    this.flightService.getFlights(searchCriteria.source, searchCriteria.destination, searchCriteria.travelDate)
      .subscribe(flights => {
        this.flights = flights;
      });
  }
}
