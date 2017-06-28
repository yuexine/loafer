import {Injectable} from "@angular/core";
import {HttpService} from "./http.service";
import {Response} from "@angular/http";

@Injectable()
export class TopicService {
  constructor(private http: HttpService) {
  }

  getActiveTopic() {
    return this.http.get(`api/topic/active`).map((response: Response) => response.json());
  }

}
