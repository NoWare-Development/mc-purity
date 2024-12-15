class BlogEntry {
  constructor(month, day, year, content) {
    this.month = month;
    this.day = day;
    this.year = year;
    this.content = content;
  }
}

function getDate(blogentry) {
  var month = "???";

  switch (blogentry.month) {
    case 1: month = "Jan"; break;
    case 2: month = "Feb"; break;
    case 3: month = "Mar"; break;
    case 4: month = "Apr"; break;
    case 5: month = "May"; break;
    case 6: month = "Jun"; break;
    case 7: month = "Jul"; break;
    case 8: month = "Aug"; break;
    case 9: month = "Sep"; break;
    case 10: month = "Oct"; break;
    case 11: month = "Nov"; break;
    case 12: month = "Dec"; break;
  }
  return `
    <h1 class="container__subheader" >- ${month} ${String(blogentry.day).padStart(2, '0')} ${String(blogentry.year).padStart(4, '0')}:</h1>
  `;
}

function getContent(blogentry) {
  return `
    <div class="blog__text" >
      <span id="gray" >${blogentry.content}</span>
    </div>
  `;
}

class Blog extends HTMLElement {
  connectedCallback() {
    var content = "";

    allBlogs.forEach(blog => {
        content += getDate(blog);
        content += getContent(blog);
      }
    )

    this.innerHTML = content;
  }
}
customElements.define("purity-blog", Blog);

const blog_07_31_24 = new BlogEntry(7, 31, 2024, `
  Uploaded new <a target="_blank" href="https://www.youtube.com/watch?v=iXivv2AYCGc" >video</a> with new dungeons showcase.

  <iframe width="560" height="315" src="https://www.youtube.com/embed/iXivv2AYCGc?si=2H6niPuhqd9ymN_R" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
`);

const blog_12_15_24 = new BlogEntry(12, 15, 2024, `
  Released a new major version 1.1.0.
`);

const allBlogs = [
  blog_12_15_24,
  blog_07_31_24,
];
