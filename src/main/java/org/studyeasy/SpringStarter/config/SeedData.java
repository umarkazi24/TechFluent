package org.studyeasy.SpringStarter.config;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.studyeasy.SpringStarter.models.Account;
import org.studyeasy.SpringStarter.models.Authority;
import org.studyeasy.SpringStarter.models.Post;
import org.studyeasy.SpringStarter.services.AccountService;
import org.studyeasy.SpringStarter.services.AuthorityService;
import org.studyeasy.SpringStarter.services.PostService;
import org.studyeasy.SpringStarter.util.constants.Privileges;
import org.studyeasy.SpringStarter.util.constants.Roles;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

        for (Privileges auth : Privileges.values()) {
            Authority authority = new Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivilege());
            authorityService.save(authority);
        }

        Account account01 = new Account();
        Account account02 = new Account();
        Account account03 = new Account();
        Account account04 = new Account();

        account01.setEmail("user@user.com");
        account01.setPassword("pass987");
        account01.setFirstname("User");
        account01.setLastname("lastname");
        account01.setAge(25);
        account01.setDate_of_birth(LocalDate.parse("1990-01-01"));
        account01.setGender("Male");

        account02.setEmail("admin@admin.com");
        account02.setPassword("pass987");
        account02.setFirstname("Admin");
        account02.setLastname("lastname");
        account02.setRole(Roles.ADMIN.getRole());
        account02.setAge(25);
        account02.setDate_of_birth(LocalDate.parse("1990-01-01"));
        account02.setGender("Female");


        account03.setEmail("editor@editor.com");
        account03.setPassword("pass987");
        account03.setFirstname("Editor");
        account03.setLastname("lastname");
        account03.setRole(Roles.EDITOR.getRole());
        account03.setAge(55);
        account03.setDate_of_birth(LocalDate.parse("1975-01-01"));
        account03.setGender("Male");

        account04.setEmail("super_editor@editor.com");
        account04.setPassword("pass987");
        account04.setFirstname("super_editor");
        account04.setLastname("lastname");
        account04.setRole(Roles.EDITOR.getRole());
        account04.setAge(40);
        account04.setDate_of_birth(LocalDate.parse("1990-01-01"));
        account04.setGender("Female");

        Set<Authority> authorities = new HashSet<>();
        authorityService.findById(Privileges.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
        authorityService.findById(Privileges.ACCESS_ADMIN_PANEL.getId()).ifPresent(authorities::add);
        account04.setAuthorities(authorities);


        accountService.save(account01);
        accountService.save(account02);
        accountService.save(account03);
        accountService.save(account04);

        List<Post> posts = postService.getAll();
        if (posts.size() == 0) {
            Post post01 = new Post();
            post01.setTitle("Post 1");
            post01.setBody("This is a post body............");
            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Spring Boot Model-View-Controller Framework");
            post02.setBody("""
            
                <h3><strong>Model-View-Controller Framework</strong></h3>
                <p><a href = "https://en.wikipedia.org/wiki/File:Spring5JuergenHoeller2.jpg"><img src = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7b/Spring5JuergenHoeller2.jpg/220px-Spring5JuergenHoeller2.jpg"></p>
                <p>The Spring Framework features its own model view controller (MVC) web application framework, which was not originally planned. The Spring developers decided to write their own Web framework as a reaction to what they perceived as the poor design of the (then) popular Jakarta Struts Web framework, as well as deficiencies in other available frameworks. In particular, they felt there was insufficient separation between the presentation and request handling layers, and between the request handling layer and the model. Like Struts, Spring MVC is a request-based framework. The framework defines strategy interfaces for all of the responsibilities that must be handled by a modern request-based framework. The goal of each interface is to be simple and clear so that it's easy for Spring MVC users to write their own implementations, if they so choose. MVC paves the way for cleaner front end code. All interfaces are tightly coupled to the Servlet API. This tight coupling to the Servlet API is seen by some as a failure on the part of the Spring developers to offer a high level of abstraction for Web-based applications. However, this coupling ensures that the features of the Servlet API remain available to developers while offering a high abstraction framework to ease working with it.</p>
                    """);
            post02.setAccount(account02);
            postService.save(post02);


            Post post03 = new Post();
            post03.setTitle("Top 10 Tips for Effective Java Programming");
            post03.setBody("Java is a versatile and widely used programming language. With its strong object-oriented " + "features, it's a great choice for building complex applications. Here are 10 tips to help " + "you become a more effective Java programmer: " + "1. Master the basics: Make sure you have a solid understanding of Java's syntax, data structures, " + "and algorithms. " + "2. Embrace Object-Oriented Programming: Java is an object-oriented language. " + "Leverage classes, objects, inheritance, and encapsulation to organize your code effectively. " + "3. Use Effective Collections: Java offers a variety of collection classes. Choose the right " + "collection type for your needs (e.g., ArrayLists for random access, LinkedLists for frequent " + "insertions/removals). " + "(Remaining tips can be added here)" + "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is a general-purpose programming language intended to let programmers write once, run anywhere (WORA),[16] meaning that compiled Java code can run on all platforms that support Java without the need to recompile.[17] Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless of the underlying computer architecture. The syntax of Java is similar to C and C++, but has fewer low-level facilities than either of them. The Java runtime provides dynamic capabilities (such as reflection and runtime code modification) that are typically not available in traditional compiled languages.\n" + "\n" + "Java gained popularity shortly after its release, and has been a very popular programming language since then. Java was the third most popular programming language in 2022 according to GitHub.[19] Although still widely popular, there has been a gradual decline in use of Java in recent years with other languages using JVM gaining popularity.[20]\n" + "\n" + "Java was originally developed by James Gosling at Sun Microsystems. It was released in May 1995 as a core component of Sun's Java platform. The original and reference implementation Java compilers, virtual machines, and class libraries were originally released by Sun under proprietary licenses. As of May 2007, in compliance with the specifications of the Java Community Process, Sun had relicensed most of its Java technologies under the GPL-2.0-only license. Oracle offers its own HotSpot Java Virtual Machine, however the official reference implementation is the OpenJDK JVM which is free open-source software and used by most developers and is the default JVM for almost all Linux distributions.\n" + "\n" + "As of March 2024, Java 22 is the latest version. Java 8, 11, 17, and 21 are previous LTS versions still officially supported.\n" + "\n");
            post03.setAccount(account03);
            postService.save(post03);


            Post post04 = new Post();
            post04.setTitle("The Struggles of a Developer: A Day in the Life");
            post04.setBody("**Morning:** Wake up with a vague sense of dread, knowing there's an impending bug to fix. " + "Spend 30 minutes searching for my missing coffee mug. Finally find it under a pile of " + "laundry. " + "**Mid-Morning:** Open my laptop and see a mountain of code. Spend the next hour deciphering " + "the logic of the previous developer. Why did they use a nested ternary operator?! " + "**Lunchtime:** Stumble out of my chair, back aching from sitting for hours. Realize I forgot " + "to eat breakfast again. Grab a questionable sandwich from the vending machine. " + "(Remaining struggles can be added here)" + "James Gosling, Mike Sheridan, and Patrick Naughton initiated the Java language project in June 1991.[21] Java was originally designed for interactive television, but it was too advanced for the digital cable television industry at the time.[22] The language was initially called Oak after an oak tree that stood outside Gosling's office. Later the project went by the name Green and was finally renamed Java, from Java coffee, a type of coffee from Indonesia.[23] Gosling designed Java with a C/C++-style syntax that system and application programmers would find familiar.[24]\n" + "\n" + "Sun Microsystems released the first public implementation as Java 1.0 in 1996.[25] It promised write once, run anywhere (WORA) functionality, providing no-cost run-times on popular platforms. Fairly secure and featuring configurable security, it allowed network- and file-access restrictions. Major web browsers soon incorporated the ability to run Java applets within web pages, and Java quickly became popular. The Java 1.0 compiler was re-written in Java by Arthur van Hoff to comply strictly with the Java 1.0 language specification.[26] With the advent of Java 2 (released initially as J2SE 1.2 in December 1998 - 1999), new versions had multiple configurations built for different types of platforms. J2EE included technologies and APIs for enterprise applications typically run in server environments, while J2ME featured APIs optimized for mobile applications. The desktop version was renamed J2SE. In 2006, for marketing purposes, Sun renamed new J2 versions as Java EE, Java ME, and Java SE, respectively.\n" + "\n" + "In 1997, Sun Microsystems approached the ISO/IEC JTC 1 standards body and later the Ecma International to formalize Java, but it soon withdrew from the process. Java remains a de facto standard, controlled through the Java Community Process. At one time, Sun made most of its Java implementations available without charge, despite their proprietary software status. Sun generated revenue from Java through the selling of licenses for specialized products such as the Java Enterprise System.\n" + "\n" + "On November 13, 2006, Sun released much of its Java virtual machine (JVM) as free and open-source software (FOSS), under the terms of the GPL-2.0-only license. On May 8, 2007, Sun finished the process, making all of its JVM's core code available under free software/open-source distribution terms, aside from a small portion of code to which Sun did not hold the copyright.[31]\n" + "\n" + "Sun's vice-president Rich Green said that Sun's ideal role with regard to Java was as an evangelist. Following Oracle Corporation's acquisition of Sun Microsystems in 2009-10, Oracle has described itself as the steward of Java technology with a relentless commitment to fostering a community of participation and transparency. This did not prevent Oracle from filing a lawsuit against Google shortly after that for using Java inside the Android SDK (see the Android section).\n" + "\n" + "On April 2, 2010, James Gosling resigned from Oracle.\n" + "\n" + "In January 2016, Oracle announced that Java run-time environments based on JDK 9 will discontinue the browser plugin.[35]\n" + "\n" + "Java software runs on everything from laptops to data centers, game consoles to scientific supercomputers.\n" + "\n" + "Oracle (and others) highly recommend uninstalling outdated and unsupported versions of Java, due to unresolved security issues in older versions.");
            post04.setAccount(account04);
            postService.save(post04);


            Post post05 = new Post();
            post05.setTitle("Spring Security: An In-Depth Review");
            post05.setBody("Spring Security is a powerful framework for securing Spring applications. It provides features " + "for authentication, authorization, and more. Here's a breakdown of Spring Security's key " + "components: " + "- SecurityContextHolder: Stores the current user's security context. " + "- AuthenticationManager: Responsible for user authentication. " + "- Authentication: Represents the authenticated user and their authorities. " + "- Authorization: Determines whether a user has permission to perform a specific operation. " + "(Detailed explanations of each component can be added here)" + "Principles\n" + "There were five primary goals in the creation of the Java language:[17]\n" + "\n" + "It must be simple, object-oriented, and familiar.\n" + "It must be robust and secure.\n" + "It must be architecture-neutral and portable.\n" + "It must execute with high performance.\n" + "It must be interpreted, threaded, and dynamic.\n" + "Versions\n" + "Main article: Java version history\n" + "As of September 2023, Java 8, 11, 17 and 21 are supported as Long-Term Support (LTS) versions.[38]\n" + "\n" + "Oracle released the last zero-cost public update for the legacy version Java 8 LTS in January 2019 for commercial use, although it will otherwise still support Java 8 with public updates for personal use indefinitely. Other vendors such as Adoptium continue to offer free builds of OpenJDK's Long-Term Support (LTS) versions. These builds may include additional security patches and bug fixes.[39]");
            post05.setAccount(account02);
            postService.save(post05);

        }
        
    }

}
