export default class ImageUploader {
  imageUpload(event) {
    let files = event.target.files; // FileList object
    // Loop through the FileList and render image files
    for (let i = 0, selectedImage; selectedImage = files[i]; i++) {
        // Only process image files.
        if (!selectedImage.type.match('image.*')) {
        	continue;
        }
        let reader = new FileReader();
        // Closure to capture the file information.
        reader.onload = (function(theFile) {
        	return function(e) {
          		// Render image
				document.getElementById('userPhoto').setAttribute('src', e.target.result);
        	};
        })(selectedImage);
        // Read in the image file as a data URL.
        reader.readAsDataURL(selectedImage);
    }
  }
}
