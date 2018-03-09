export default class CommentService {
  constructor(startUrl) {
    this.startUrl = startUrl;
  }

  create(comment) {
    return fetch(this.startUrl + "comment", {
      method: "post",
      headers: new Headers({
        "Content-type": "application/json;chartSet=UTF-8"
      }),
      body: JSON.stringify(comment)
    });
  }

}
