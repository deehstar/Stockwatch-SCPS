import { StockTimeSeries } from './StockTimeSeries';
export interface Stock {
    id: number;
    name: string;
    symbol: string;
    stockTimeSeries: StockTimeSeries[];
}