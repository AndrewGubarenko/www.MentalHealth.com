export default class CommentService {
  constructor(startUrl) {
    this.startUrl = startUrl;
  }

  create(comment, id) {
    return fetch(this.startUrl + "UserViewPage/" + id, {
      method: "post",
      headers: new Headers({
        "Content-type": "application/json;chartSet=UTF-8"
      }),
      body: JSON.stringify(comment)
    });
  }

  getList(id) {
    return fetch(this.startUrl + "UserViewPage/" + id, {
      method: "get",
      headers: new Headers({
        "Content-type": "application/json;chartSet=UTF-8"
      }),
    });
  }

}
