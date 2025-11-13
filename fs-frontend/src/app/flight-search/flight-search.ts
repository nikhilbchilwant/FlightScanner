import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-flight-search',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './flight-search.html',
  styleUrl: './flight-search.css'
})
export class FlightSearch {
  @Output() search = new EventEmitter<any>();
  searchForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.searchForm = this.fb.group({
      source: [''],
      destination: [''],
      travelDate: ['']
    });
  }

  onSubmit() {
    this.search.emit(this.searchForm.value);
  }
}
