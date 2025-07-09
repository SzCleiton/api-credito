import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { ConsultaCreditoComponent } from './consulta-credito.component';

const routes: Routes = [
  { path: '', component: ConsultaCreditoComponent }
];

@NgModule({
  declarations: [ConsultaCreditoComponent],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule.forChild(routes)
  ]
})
export class ConsultaCreditoModule { }
