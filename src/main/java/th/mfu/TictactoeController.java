package th.mfu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.transaction.Transactional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.mfu.domain.game;
import th.mfu.domain.loser;
import th.mfu.domain.player;
import th.mfu.domain.winner;

@Controller
public class TictactoeController {
    private static final Logger logger = LoggerFactory.getLogger(TictactoeController.class);
    private static final Random random = new Random();
    private static final Set<String> useIds = new HashSet<>();
    player p1 = null;
    player p2 = null;

    @Autowired
    Playerrepository playerrepo;

    @Autowired
    WinnerRepository winnerrepo;

    @Autowired
    LoserRepository loserrepo;

    private static String generateRandomNumericId(int length)
     {
        StringBuilder id = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            id.append(random.nextInt(10));
        }
        return id.toString();
    }
    public static String generateUniqueRandomNumericId(int length) 
    {
        while (true) {
            double tempId=Math.random()*100000;
            String id=String.valueOf((int)tempId);
            if (!useIds.contains(id)) {
                useIds.add(id);
                return id;
            }
        }
    }

    
    public TictactoeController(Playerrepository playerrepio, WinnerRepository winnerrepo, LoserRepository loserrepo) {

        this.playerrepo = playerrepio;
        this.winnerrepo = winnerrepo;
        this.loserrepo = loserrepo;
    }


    @GetMapping("/")
    public String tictactoe(Model model) {
        model.addAttribute("Model", model);
        return "homepageX";
    }


    @GetMapping("/XSignUp")
    public String signUp(Model model) {

        return "Xsignup1";
    }


    @PostMapping("/XSignUp")
    public String UserName(Model model, @RequestParam String ingamename) {
        model.addAttribute("name", new game());
        Long id = Long.parseLong(generateUniqueRandomNumericId(5));
        p1 = new player(id, ingamename);
        playerrepo.save(p1);
        model.addAttribute("id", p1.getId());
        return "Xsignup2";
    }


    @GetMapping("/XSignUp/{id}")
    public String Xsignup(@ModelAttribute player newplayer, @PathVariable long id) {
        String uniqueId = generateUniqueRandomNumericId(5);
        newplayer.setId(Long.valueOf(uniqueId));
        // idrepo.save(newplayer);
        return "homepageO";
    }



    @GetMapping("/OSignUp")
    public String signUp1(Model model) {
        return "Osignup1";
    }

    @PostMapping("/OSignUp")
    public String UserName1(Model model, @RequestParam String ingamename) {
        model.addAttribute("name", new game());
        Long id = Long.parseLong(generateUniqueRandomNumericId(5));
        p2 = new player(id, ingamename);
        playerrepo.save(p2);
        model.addAttribute("id", p2.getId());
        return "Osignup2";
    }
    
    @Transactional
    @GetMapping("/OSignUp/{id}")
    public String Osignup(@ModelAttribute player newplayer, @PathVariable long id) {
        String Id = generateRandomNumericId(5);
        id = Long.valueOf(Id);
        newplayer.setId(id);
        // idrepo.save(newplayer);
        return "final";
    }


    @GetMapping("/restartgame")
    public String restart(Model model) {
        return "final";
    }


    @GetMapping("/replay")
    public String replay(Model model) {
        return "final";
    }


    @GetMapping("/tie")
    public String Tie(Model model) {
        return "XOtie";
    }


    @GetMapping("/Xwin")
    public String Xwinner(@ModelAttribute winner winner, @ModelAttribute loser loser) {

        winner.setPlayer(p1);
        winner.setId(p1.getId());
        winner.setName(p1.getName());
        winnerrepo.save(winner);
        logger.info("Inside Xwinner method");
        loser.setPlayer(p2);
        loser.setId(p2.getId());
        loser.setName(p2.getName());
        loserrepo.save(loser);
        logger.info("Inside Oloser method");

        return "Xwinner";
    }


    @GetMapping("/Owin")
    public String Owinner(@ModelAttribute winner winner, @ModelAttribute loser loser) {
        winner.setPlayer(p2);
        winner.setId(p2.getId());
        winner.setName(p2.getName());
        winnerrepo.save(winner);
        logger.info("Inside Owinner method");

        loser.setPlayer(p1);
        loser.setId(p1.getId());
        loser.setName(p1.getName());
        loserrepo.save(loser);
        logger.info("Inside Xloser method");

        return "Owinner";
    }


    @GetMapping("/Xlogin")
    public String showXLoginPage() {
        return "Xlogin";
    }


    @PostMapping("/Xlogin")
    public String loginX(@RequestParam Long playerId, Model model) {
        player player = playerrepo.findById(playerId).orElse(null);

        if (player != null) {
            model.addAttribute("player", player);
            return "homepageO";
        } else {
            return "homepageX2";
        }
    }


    @GetMapping("/Ologin")
    public String showOLoginPage() {
        return "Ologin";
    }


    @PostMapping("/Ologin")
    public String loginO(@RequestParam Long playerId, Model model) {
        player player = playerrepo.findById(playerId).orElse(null);

        if (player != null) {
            model.addAttribute("player", player);
            return "final";
        } else {
            return "homepageO2";
        }
    }


    @GetMapping("/leaderboard")
    public String finalPage(Model model) {
        // Retrieve the winners and losers from the repositories
        ArrayList<winner> winners = (ArrayList<winner>) winnerrepo.findAll();
        ArrayList<loser> losers = (ArrayList<loser>) loserrepo.findAll();

        // Add the winners and losers to the model
        model.addAttribute("winners", winners);
        model.addAttribute("losers", losers);

        // Return the template name
        return "leaderboard";
    }

}


















































/* //TODO: add initbinder to convert date
    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    } */
