<!DOCTYPE html><html><head><meta charset="utf-8"><title>README.md</title><style></style></head><body id="preview">
<h1 class="code-line" data-line-start=2 data-line-end=3><a id="Msdbjavatest_2"></a>Ms-db-java-test</h1>
<ul>
<li class="has-line-data" data-line-start="4" data-line-end="6">This project is for the registration of user</li>
</ul>
<h3 class="code-line" data-line-start=6 data-line-end=7><a id="Diagrams_6"></a>Diagrams</h3>
<ul>
<li class="has-line-data" data-line-start="7" data-line-end="8">Sequence Diagrams</li>
<li class="has-line-data" data-line-start="8" data-line-end="9">Component Diagrams</li>
<li class="has-line-data" data-line-start="9" data-line-end="11">Class Diagrams</li>
</ul>
<p class="has-line-data" data-line-start="11" data-line-end="12">You can see that :</p>
<p class="has-line-data" data-line-start="13" data-line-end="15">Url Repository Diagrams [public repository][<a href="https://github.com/maa-rojasd/ms-db-java-test/tree/master/diagrams">https://github.com/maa-rojasd/ms-db-java-test/tree/master/diagrams</a>]<br>
on GitHub.</p>
<h3 class="code-line" data-line-start=17 data-line-end=18><a id="Tech_17"></a>Tech</h3>
<p class="has-line-data" data-line-start="19" data-line-end="20">Dillinger uses a number of open source projects to work properly:</p>
<ul>
<li class="has-line-data" data-line-start="21" data-line-end="22">[Java] - Springboot aplication</li>
<li class="has-line-data" data-line-start="22" data-line-end="23">Java 1.8</li>
<li class="has-line-data" data-line-start="23" data-line-end="24">Gradle</li>
<li class="has-line-data" data-line-start="24" data-line-end="25">SpringBoot 2.2.6 Release</li>
<li class="has-line-data" data-line-start="25" data-line-end="26">Lombok</li>
<li class="has-line-data" data-line-start="26" data-line-end="27">JWT</li>
<li class="has-line-data" data-line-start="27" data-line-end="28">JPA</li>
<li class="has-line-data" data-line-start="28" data-line-end="29">Hibernate</li>
<li class="has-line-data" data-line-start="29" data-line-end="30">Database H2</li>
</ul>
<p class="has-line-data" data-line-start="32" data-line-end="34">Url Repository [public repository][<a href="https://github.com/maa-rojasd/ms-db-java-test">https://github.com/maa-rojasd/ms-db-java-test</a>]<br>
on GitHub.</p>
<h3 class="code-line" data-line-start=35 data-line-end=36><a id="Installation_35"></a>Installation</h3>
<p class="has-line-data" data-line-start="37" data-line-end="39">Dillinger requires download <a href="https://github.com/maa-rojasd/ms-db-java-test">public repository</a> from GitHub.<br>
Or clone repositiry</p>
<ul>
<li class="has-line-data" data-line-start="39" data-line-end="41">Git Clone <a href="https://github.com/maa-rojasd/ms-db-java-test.git">https://github.com/maa-rojasd/ms-db-java-test.git</a></li>
</ul>
<p class="has-line-data" data-line-start="41" data-line-end="42">Next you need import proyect</p>
<p class="has-line-data" data-line-start="43" data-line-end="44">For Eclipse import</p>
<pre><code class="has-line-data" data-line-start="46" data-line-end="48" class="language-sh">$ File &gt; Import&gt; Existing Gradle Project
</code></pre>
<p class="has-line-data" data-line-start="49" data-line-end="50">For Intellij import</p>
<pre><code class="has-line-data" data-line-start="52" data-line-end="54" class="language-sh">$ Gradle tool window &gt; to attach a Gradle project&gt; Import Module from Gradle window
</code></pre>
<p class="has-line-data" data-line-start="55" data-line-end="56">Install the dependencies and devDependencies and start the server.</p>
<pre><code class="has-line-data" data-line-start="58" data-line-end="61" class="language-sh">$ <span class="hljs-built_in">cd</span> ms-db-java-test/
$ gradle clean build
</code></pre>
<h3 class="code-line" data-line-start=65 data-line-end=66><a id="Development_65"></a>Development</h3>
<p class="has-line-data" data-line-start="67" data-line-end="68">Want to contribute? Great!</p>
<p class="has-line-data" data-line-start="69" data-line-end="71">Dillinger uses Gulp + Webpack for fast developing.<br>
Make a change in your file and instantaneously see your updates!</p>
<p class="has-line-data" data-line-start="72" data-line-end="73">Open your favorite Terminal and run these commands.</p>
<p class="has-line-data" data-line-start="74" data-line-end="75">First Tab:</p>
<pre><code class="has-line-data" data-line-start="76" data-line-end="78" class="language-sh">$ Gradle run
</code></pre>
<p class="has-line-data" data-line-start="78" data-line-end="79">Or in Eclipse</p>
<p class="has-line-data" data-line-start="80" data-line-end="81">In QuickAcces:</p>
<pre><code class="has-line-data" data-line-start="82" data-line-end="84" class="language-sh">$ Find BootDashboard &gt; rigth click &gt; restart
</code></pre>
<p class="has-line-data" data-line-start="85" data-line-end="86">Download the postman collection <a href="https://github.com/maa-rojasd/ms-db-java-test/tree/master/postman">postman-collection</a> from GitHub.:</p>
<pre><code class="has-line-data" data-line-start="87" data-line-end="89" class="language-sh">$ Import Postman collection
</code></pre>
<p class="has-line-data" data-line-start="89" data-line-end="90">First step &gt; Use the endpoint</p>
<pre><code class="has-line-data" data-line-start="91" data-line-end="93" class="language-sh">$ localhost:<span class="hljs-number">8001</span>/V1/UserToken
</code></pre>
<p class="has-line-data" data-line-start="94" data-line-end="95">Second step &gt; Use the endpoint</p>
<pre><code class="has-line-data" data-line-start="96" data-line-end="98" class="language-sh">$ http://localhost:<span class="hljs-number">8001</span>/V1/Registro
</code></pre>
<p class="has-line-data" data-line-start="99" data-line-end="100">Third step &gt; Use the endpoint</p>
<pre><code class="has-line-data" data-line-start="101" data-line-end="105" class="language-sh">$ http://localhost:<span class="hljs-number">8001</span>/V1/UpdateRegistro 
And 
http://localhost:<span class="hljs-number">8001</span>/V1/Login
</code></pre>
</body></html>