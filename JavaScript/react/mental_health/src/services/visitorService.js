export default class VisitorService {
  constructor(startUrl) {
    this.startUrl = startUrl;
  }
  getFullProfile(id) {
    return fetch(this.startUrl + "UserViewPage/" + id, {
      method: "get",
      headers: new Headers({
        "Content-type": "application/json;chartSet=UTF-8",
      })
    });
  }
}
