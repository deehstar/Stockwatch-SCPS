import { Component, OnInit, inject } from '@angular/core';
import { StockServiceService } from './_services/stock-service.service';
import { Stock } from './_models/Stock';

@Component({
  selector: 'app-stock',
  standalone: true,
  imports: [],
  templateUrl: './stock.component.html',
  styleUrl: './stock.component.css'
})
export class StockComponent {
  
  stockService: StockServiceService = inject(StockServiceService);
  stock: Stock | null = null;
  stocks: Stock[] = [];
  
  updateStocks() {
    this.stockService.updateStocks();
    this.stockService.getStocks().subscribe(stocks => this.stocks = stocks);
  }
}
