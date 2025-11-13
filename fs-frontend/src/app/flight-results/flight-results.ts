import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-flight-results',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './flight-results.html',
  styleUrl: './flight-results.css'
})
export class FlightResults {
  @Input() flights: any[] = [];
}
