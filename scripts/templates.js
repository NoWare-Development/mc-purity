class PurityHeader extends HTMLElement {
  connectedCallback() {
    this.innerHTML = `
      <header class="stone" >
        <div class="navbar" >
          <a class="navlink" href="./purity.html" >Home</a>
          <a class="navlink" href="./blog.html" >Blog</a>
          <a class="navlink" href="./download.html" >Download</a>
          <a class="navlink" href="./gallery.html" >Gallery</a>
          <a class="navlink" href="./wiki.html" >Wiki</a>
          <a class="navlink" target="_blank" href="https://github.com/NoWare-Development/mc-purity" >GitHub</a>
          <a class="navlink" target="_blank" href="https://youtube.com/@nyvyme" >YouTube</a>
          <a class="navlink" target="_blank" href="https://t.me/mcpurity" >Telegram</a>
        </div>
        <div class="logo__container" >
          <a href="./purity.html" >
            <img class="logo" src="./../media/mc-purity-logo.png" />
          </a>
        </div>
      </header>
    `
  }
}
customElements.define("purity-header", PurityHeader);
