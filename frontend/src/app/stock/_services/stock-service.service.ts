import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Stock } from '../_models/Stock';

@Injectable({
  providedIn: 'root'
})
export class StockServiceService {
  private stockUrl = 'http://localhost:8080/api/v1/stock';
  private httpClient: HttpClient = inject(HttpClient);
  
  getStocks(): Observable<Stock[]> {
    return this.httpClient.get<Stock[]>(this.stockUrl);
  }

  getStock(id: number): Observable<Stock> {
    return this.httpClient.get<Stock>(`${this.stockUrl}/${id}`);
  }

  updateStocks() {
    return this.httpClient.put(this.stockUrl, null);
  }
}
