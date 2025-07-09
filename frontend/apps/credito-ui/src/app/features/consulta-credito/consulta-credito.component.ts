import { Component } from '@angular/core';
import { finalize } from 'rxjs/operators';
import { Credito, CreditoService } from '../../core/services/credito.service';

@Component({
  selector: 'app-consulta-credito',
  templateUrl: './consulta-credito.component.html',
})
export class ConsultaCreditoComponent {
  searchType: 'nfse' | 'credito' = 'nfse';
  searchValue: string = '';
  creditos: Credito[] = [];
  isLoading: boolean = false;
  errorMessage: string | null = null;
  searchPerformed: boolean = false;

  constructor(private creditoService: CreditoService) {}

  onSearch(): void {
    if (!this.searchValue.trim()) return;
    this.isLoading = true;
    this.errorMessage = null;
    this.creditos = [];
    this.searchPerformed = true;

    const search$ = this.searchType === 'nfse'
      ? this.creditoService.getCreditosByNfse(this.searchValue)
      : this.creditoService.getCreditoByNumero(this.searchValue);

    search$.pipe(
      finalize(() => this.isLoading = false)
    ).subscribe({
      next: (data) => this.creditos = Array.isArray(data) ? data : [data],
      error: (err) => this.errorMessage = err.message
    });
  }
}
