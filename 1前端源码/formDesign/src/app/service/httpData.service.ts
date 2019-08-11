import { Injectable } from '@angular/core';

@Injectable()
export class HttpDataService {
  Manage_HOST: string;
  Editor_HOST: string;
  Editor_96HOST: string;
  API_HOST: string;
  constructor() {
    let localHost = window.location.host;
    // localHost = '47.106.147.174'; //
    //localHost = '120.78.75.246';//六
    // localHost = '47.112.212.35';//三
    // localHost = 'www.1388w.cn';
    // localHost = '192.168.0.213';
    // localHost = '192.168.0.237';
    // localHost = '127.0.0.1';

    this.Manage_HOST = 'http://' + localHost + ':20890/';
    this.Editor_HOST = 'http://' + localHost + ':20890/';
    this.Editor_96HOST = 'http://' + localHost + ':20896/';

    /*
              this.Manage_HOST = 'http://192.168.0.192:20890/';
              this.Editor_HOST = 'http://192.168.0.192:20890/';*/

    /*this.Manage_HOST = 'http://1388w.cn:20890/';
            this.Editor_HOST = 'http://1388w.cn:208902/';*/
  }
}
