class BlogEntry {
  constructor(date, content) {
    this.date = date;
    this.content = content;
  }
}

function getDate(blogentry) {
  return `
    <h1 class="container__subheader" >- ${blogentry.date}:</h1>
  `;
}

function getContent(blogentry) {
  return `
    <div class="blog__text" >
      <span id="gray" >${blogentry.content}</span>
    </div>
  `;
}

const blog_07_31_24 = new BlogEntry("07.31.24", `
  Uploaded new <a href="https://www.youtube.com/watch?v=iXivv2AYCGc" >video</a> with new dungeons showcase.

  <iframe width="560" height="315" src="https://www.youtube.com/embed/iXivv2AYCGc?si=2H6niPuhqd9ymN_R" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
`);

const allBlogs = [
  blog_07_31_24
];

class Blog extends HTMLElement {
  connectedCallback() {
    var content = "";

    allBlogs.forEach(blog => {
        content += getDate(blog);
        content += `\n`;
        content += getContent(blog);
      }
    )

    this.innerHTML = content;
  }
}
customElements.define("purity-blog", Blog);
