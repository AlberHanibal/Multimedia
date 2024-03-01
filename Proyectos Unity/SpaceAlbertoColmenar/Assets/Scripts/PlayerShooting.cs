using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerShooting : MonoBehaviour
{
    public GameObject bulletPrefab;
    public float fireDelay = 0.25f;
    float cooldownTimer = 0;

    void Update()
    {
        cooldownTimer -= Time.deltaTime;
        if (Input.GetButton("Fire1") && cooldownTimer <= 0)
        {
            cooldownTimer = fireDelay;

            Instantiate(bulletPrefab, transform.GetChild(0).position, transform.GetChild(0).rotation);
            Instantiate(bulletPrefab, transform.GetChild(1).position, transform.GetChild(1).rotation);
        }
    }
    
    
}
