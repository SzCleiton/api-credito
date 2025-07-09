import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'consulta',
    // Lazy Loading: O módulo só é carregado quando a rota é acessada
    loadChildren: () => import('./features/consulta-credito/consulta-credito.module').then(m => m.ConsultaCreditoModule)
  },
  { path: '', redirectTo: 'consulta', pathMatch: 'full' },
  { path: '**', redirectTo: 'consulta' } // Rota coringa
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
