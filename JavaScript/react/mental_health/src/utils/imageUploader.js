export default class ImageUploader {

  async imageUpload (event, image) {

    let sleep = (ms) => {
      return new Promise(resolve => setTimeout(resolve, ms));
    }

    let selectedImage = event.target.files[0];
    let reader = new FileReader();
    let encodedBase64Value;

    reader.onload = (event) => {
      image.src = event.target.result;
      encodedBase64Value = btoa(image.src);
    }
    reader.readAsDataURL(selectedImage);
    await sleep(1000);
    return encodedBase64Value;
  }

  imageMount = (encodedBase64Value, image) => {
    image.src = atob(encodedBase64Value);
  }
}
