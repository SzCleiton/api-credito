import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from '../../../environments/environment';

export interface Credito {
  numeroCredito: string;
  numeroNfse: string;
  dataConstituicao: string;
  valorIssqn: number;
  tipoCredito: string;
  simplesNacional: boolean;
  aliquota: number;
  valorFaturado: number;
  valorDeducao: number;
  baseCalculo: number;
}

@Injectable({
  providedIn: 'root'
})
export class CreditoService {
  private apiUrl = `${environment.apiUrl}/creditos`;

  constructor(private http: HttpClient) { }

  getCreditosByNfse(numeroNfse: string): Observable<Credito[]> {
    return this.http.get<Credito[]>(`${this.apiUrl}/${numeroNfse}`)
      .pipe(catchError(this.handleError));
  }

  getCreditoByNumero(numeroCredito: string): Observable<Credito> {
    return this.http.get<Credito>(`${this.apiUrl}/credito/${numeroCredito}`)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Ocorreu um erro desconhecido!';
    if (error.status === 404) {
      errorMessage = 'Nenhum registro encontrado para o critério informado.';
    } else if (error.status === 0) {
      errorMessage = 'Não foi possível conectar à API. Verifique se o backend está em execução.';
    }
    return throwError(() => new Error(errorMessage));
  }
}
