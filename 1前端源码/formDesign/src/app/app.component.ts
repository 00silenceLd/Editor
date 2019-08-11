import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
	
	approvePage:number=0;
	
	private approveBtn(){
		if(this.approvePage==0){
			this.approvePage=1;
		}else{
				this.approvePage=0;
		}
	}
}
